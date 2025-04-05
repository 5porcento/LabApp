import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import java.io.File

class FichaAnaliseViewModel {
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

            val file = File("/storage/emulated/0/Download/ParametrosSelecionados.pdf")
            document.save(file)

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            document.close()
        }
    }
}
