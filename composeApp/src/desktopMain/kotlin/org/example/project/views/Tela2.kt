package org.example.project.views


import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import java.io.File

val opcoes= listOf(
    "ph",
    "Cor",
    "Turbidez",
    "Cloro Residual",
    "Coliformes Totais",
    "Coliformes Fecais",)

@Composable
fun Tela2() {
    val opcoesSelecionadas = remember { mutableStateListOf<String>() }
    val scrollState = rememberScrollState()

   Column {
        Text("Selecione os parâmetros:", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        // Criando as checkboxes para cada opção disponível
        opcoes.forEach { opcao ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = opcao in opcoesSelecionadas,
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            opcoesSelecionadas.add(opcao)
                        } else {
                            opcoesSelecionadas.remove(opcao)
                        }
                    }
                )
                Text(opcao)
            }
        }

       fun gerarPDFComPDFBox(opcoes: List<String>) {
           val document = PDDocument()
           val page = PDPage()
           document.addPage(page)

           try {
               val contentStream = PDPageContentStream(document, page)
               contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16f)
               contentStream.beginText()
               contentStream.newLineAtOffset(50f, 700f)
               contentStream.showText("Parâmetros Selecionados")
               contentStream.endText()

               contentStream.setFont(PDType1Font.HELVETICA, 12f)
               var yPosition = 680f

               // Adiciona as opções selecionadas ao PDF
               opcoes.forEach { parametro ->
                   contentStream.beginText()
                   contentStream.newLineAtOffset(50f, yPosition)
                   contentStream.showText("- $parametro")
                   contentStream.endText()
                   yPosition -= 20f
               }

               contentStream.close()

               val file = File("Teste.pdf")
               document.save(file)

           } catch (e: Exception) {
               e.printStackTrace()
           } finally {
               document.close()
           }
       }

       Button(onClick = {
           gerarPDFComPDFBox(opcoesSelecionadas.toList())
       }) {
            Text("Gerar PDF")
        }
    }
}
