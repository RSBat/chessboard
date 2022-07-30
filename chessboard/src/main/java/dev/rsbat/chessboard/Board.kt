package dev.rsbat.chessboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Board(boardData: Array<Array<Piece>>, modifier: Modifier = Modifier) {
    val lightColor = Color(0xff422e2f)
    val darkColor = Color(0xfffef5e4)
    Column(modifier = modifier) {
        for (rowIdx in 7 downTo 0) {
            Row {
                for (colIdx in 0 until 8) {
                    val isLightSquare = (rowIdx + colIdx) % 2 == 1
                    val squareColor = if (isLightSquare) lightColor else darkColor
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(squareColor)
                    ) {
                        Image(
                            painter = painterResource(id = boardData[rowIdx][colIdx].drawableRes),
                            contentDescription = "Bishop",
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.Center,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewEmptyBoard() {
    Board(boardData = Array(8) { Array(8) { Piece.None } })
}
