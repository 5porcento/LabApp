package org.example.project.pdf

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import java.io.File


fun pdfOrcamento(
     nomeCliente:String, cnpj:String, nomeComercial:String, siteEmpresa:String, endereco:String,
 telefone:String, emailEmpresa:String, nomeRepresentante:String, foneRepresentante:String, emailRepresentante:String,
 nomeLaboratorio:String, siglaLaboratorio:String, nomeCoordenador:String, cpfCoordenador:String, tecnico1:String,
 cpfTecnico1:String, tecnico2:String, cpfTecnico2:String, detalhesDoServico:String,
 dataInicio:String, dataTermino:String, totalDiasTrabalhado :String, valor:String, desconto:String,valorFinal:String,formaDePagamento:List<String>
){
    val document = PDDocument()
    val page = PDPage()
    document.addPage(page)

    try {
        var contentStream = PDPageContentStream(document, page)
        var yPosition = 700f


        fun verificarEspaco(alturaMinima: Float = 50f) {
            if (yPosition <= alturaMinima) {
                contentStream.close()
                val novaPagina = PDPage()
                document.addPage(novaPagina)
                yPosition = 750f
                contentStream = PDPageContentStream(document, novaPagina)
            }
        }

        fun escreverTitulo(titulo: String) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14f)
            contentStream.beginText()
            contentStream.newLineAtOffset(50f, yPosition)
            contentStream.showText(titulo)
            contentStream.endText()
            yPosition -= 20f
            verificarEspaco()
        }

        fun escreverLista(lista: List<String>) {
            contentStream.setFont(PDType1Font.HELVETICA, 12f)
            lista.forEach { item ->
                contentStream.beginText()
                contentStream.newLineAtOffset(50f, yPosition)
                contentStream.showText("- $item")
                contentStream.endText()
                yPosition -= 20f
            }
            yPosition -= 10f
            verificarEspaco()
        }



        // Informações do usuário
        escreverTitulo("Dados do Contratante :")
        val dadosContratante = listOf(
            "Razão Social/Nome Completo: $nomeCliente",
            "Nome Comercial: $nomeComercial",
            "Fone: $foneRepresentante",
            "Email: $emailRepresentante",
            "Email da Empresa: $emailEmpresa",
            "Endereço Completo: $endereco",
            "Nome do Representante: $nomeRepresentante",
            "Site da empresa: $siteEmpresa",
            "Fone : $foneRepresentante",
            "DDD/Telefone: $telefone",
            "CNPJ/CPF: $cnpj"
        )
        escreverLista(dadosContratante)

        escreverTitulo("Dados do Laboratório Prestador Do Serviço :")
        val dadosDoLab = listOf(
            "Nome do Laboratorio: $nomeLaboratorio",
            "Fone: $siglaLaboratorio",
            "Nome do Coodernador Reponsavel pela Execução do Serviço: $nomeCoordenador",
            "CPF: $cpfCoordenador",
            "Nome do Tecnico Reponsavel pela Execução do Serviço: $tecnico1",
            "CPF: $cpfTecnico1",
            "Nome do Tecnico Reponsavel pela Execução do Serviço : $tecnico2",
            "CPF: $cpfTecnico2",
        )
        escreverLista(dadosDoLab)

        escreverTitulo("Dados do Serviço:")
        val dadosDoservico = listOf(
            "Necessidades do demandante,serviços a serem execultados e resultados a serem entregues: $detalhesDoServico",
            "Data de inicio: $dataInicio",
            "Data de Termibo: $dataTermino",
            "Total de dias Trabalhados: $totalDiasTrabalhado"
        )
        escreverLista(dadosDoservico)

        escreverTitulo("Pagamento:")
        val dadosDoPagamento = listOf(
            "Valor: $valor",
            "Desconto de ate 20%: $desconto",
            "Valor Final(R$): $valorFinal",
        )
        escreverLista(dadosDoPagamento)


        // Parâmetros Selecionados
        escreverTitulo("Forma de Pagamento:")
        escreverLista(formaDePagamento)

        escreverTitulo("Dados bancários para pagamento (somente via transferência ou depósito):")
        escreverTitulo("Banco do Brasil")
        escreverTitulo("Agência: 3702-8")
        escreverTitulo("Razão Social/CNPJ: Fundação de Ciência e Tecnologia Guamá - 11.024.200/0001-09")


        contentStream.close()
        val file = File("Ficha_de_Orçamento.pdf")
        document.save(file)

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        document.close()
    }

}