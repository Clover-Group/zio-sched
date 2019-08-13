package hello

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

case class WordCount(word: String, count: Int)

object Main extends App {

  val env  = StreamExecutionEnvironment.getExecutionEnvironment
  val text = env.socketTextStream("localhost", 9999)

  val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }.map { WordCount(_, 1) }
    .keyBy("word")
    .timeWindow(Time.seconds(5))
    .sum("count")

  counts.print

  env.execute("Window Stream WordCount")
}
