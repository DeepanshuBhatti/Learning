class Matrix {

    companion object {
        fun getIdentityMatrix(size: Int): List<List<Int>> {
            val identityMatrix = mutableListOf<List<Int>>()
            for (i in 0 until size) {
                val matrixRow = MutableList(size) { 0 }
                matrixRow[i] = 1
                identityMatrix.add(matrixRow)
            }
            return identityMatrix
        }

        /**
         * computeCost calculates J i.e. the cost function using squared difference
         *
         */
        fun computeCost(featuresSet: List<List<Double>>, outputSet: List<Double>, theta: List<List<Double>>): Double {
            val p = this.multiplyMatrices(featuresSet, theta);

            var cost = 0.0
            if (p[0].size == 1) {
                val f = p.map { it[0] }
                val m = outputSet.size
                val sq = getSquaredDifference(f, outputSet)
                cost = sq.sum() / (2 * m);
            }
            return cost
        }

        private fun getSquaredDifference(a: List<Double>, b: List<Double>): List<Double> {
            if (a.size != b.size) {
                return emptyList()
            }

            val finalSquaredDifferenceList = mutableListOf<Double>()
            for (i in a.indices) {
                var f = a[i] - b[i]
                f *= f
                finalSquaredDifferenceList.add(f)
            }
            return finalSquaredDifferenceList
        }

        fun getMatrixFromList(inputsList: List<Double>): List<List<Double>> {
            val finalMatrix = mutableListOf<List<Double>>()
            for (ele in inputsList) {
                val z = listOf(1.0, ele)
                finalMatrix.add(z)
            }
            return finalMatrix
        }

        private fun multiplyMatrices(firstMatrix: List<List<Double>>, secondMatrix: List<List<Double>>): List<List<Double>> {
            val product = mutableListOf<List<Double>>()
            val r1 = firstMatrix.size
            val c1 = firstMatrix[0].size
            val r2 = secondMatrix.size
            val c2 = secondMatrix[0].size
            if (c1 != r2) {
                return emptyList()
            }

            for (i in 0 until r1) {
                val row = mutableListOf<Double>()
                for (j in 0 until c2) {
                    var element = 0.0;
                    for (k in 0 until c1) {
                        element += firstMatrix[i][k] * secondMatrix[k][j]
                    }
                    row.add(element)
                }
                product.add(row)
            }

            return product
        }

    }
}