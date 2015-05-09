package nodes.stats

import breeze.linalg._
import breeze.stats.distributions._
import pipelines.Transformer

/**
 *  A node that takes in DenseVector[Double] and randomly flips
 *  the sign of some of the elements
 */

case class RandomSignNode(signs: DenseVector[Double])
    extends Transformer[DenseVector[Double], DenseVector[Double]] {

  def apply(in: DenseVector[Double]): DenseVector[Double] = in :* signs

}

object RandomSignNode {
  /* Create a random sign node */
  def apply(size: Int): RandomSignNode = {
    val signs = 2.0*convert(DenseVector.rand(size, Binomial(1, 0.5)), Double) - 1.0
    new RandomSignNode(signs)
  }
}
