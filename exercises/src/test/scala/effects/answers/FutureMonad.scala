package exercises.answers

import minitest._

object FutureMonadTests extends SimpleTestSuite {

  import scala.concurrent._
  import scala.concurrent.duration._
  import scala.concurrent.ExecutionContext.Implicits.global

  case class ItemId(value: Int)
  case class Item(id: ItemId, qty: Int)

  def load(id: ItemId): Future[Item] =
    Future { Item(id, 100) }

  def save(item: Item): Future[Unit] =
    Future { () }

  def checkIn(qty: Int, item: Item): Item =
    item.copy(qty = item.qty + qty)

  test("scenario") {
    // load an item
    val program = load(ItemId(1))
    // checkIn 10
      .map(checkIn(10, _))
      // save item
      .flatMap(save)

    // run the computation
    Await.result(program, 1.second)

    () // keep for the test
  }

}