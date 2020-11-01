fun main() {
    print("${Matrix.getIdentityMatrix(5)}")
    val X = Matrix.getMatrixFromList(TestData.X)
    val y = Matrix.getMatrixFromList(TestData.y)
    val theta = listOf(listOf(-1.0), listOf(2.0))

    val f = Matrix.computeCost(X, TestData.y, theta)
    println("$f")
}
