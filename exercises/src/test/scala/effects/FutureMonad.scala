package exercises

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
    // checkIn 10
    // save item
    // run the computation

    () // keep for the test
  }

}