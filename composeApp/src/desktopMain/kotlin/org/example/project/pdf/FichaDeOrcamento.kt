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
 dataInicio:String, dataTermino:String, totalDiasTrabalhado :String, valor:String, desconto:String,
){
    val document = PDDocument()
    val page = PDPage()
    document.addPage(page)

    try {
        val contentStream = PDPageContentStream(document, page)
        var yPosition = 700f

        fun escreverTitulo(titulo: String) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14f)
            contentStream.beginText()
            contentStream.newLineAtOffset(50f, yPosition)
            contentStream.showText(titulo)
            contentStream.endText()
            yPosition -= 20f
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
        }

        // Informações do usuário
        escreverTitulo("Dados do Contratante :")
        val dadosContratante = listOf(
            "Razão Social/Nome Completo: $nomeCliente",
            "Fone: $foneRepresentante",
            "Email: $emailEmpresa",
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

        escreverTitulo("Dados do Laboratório Prestador Do Serviço :")
        val dadosDoservico = listOf(
            "Nome do Laboratorio: $nomeLaboratorio",
            "Fone: $siglaLaboratorio",
            "Nome do Coodernador Reponsavel pela Execução do Serviço: $nomeCoordenador",
            "CPF: $cpfCoordenador",
            "Nome do Tecnico Reponsavel pela Execução do Serviço: $tecnico1",
            "CPF: $cpfTecnico1",
            "Nome do Tecnico Reponsavel pela Execução do Serviço : $tecnico2",
            "CPF: $cpfTecnico2",
        )
        escreverLista(dadosDoservico)

        // Parâmetros Selecionados
//        escreverTitulo("Parâmetros Selecionados:")
//        escreverLista(opcoes)

        // Tratamento da Água
//        escreverTitulo("Tratamento da Água:")
//        escreverLista(opcoesTratamento)

        // Uso da Água
//        escreverTitulo("Uso da Água:")
//        escreverLista(usoDaAgua)

        // Origem da Amostra
//        escreverTitulo("Origem da Amostra:")
//        escreverLista(origemAmostra)

        contentStream.close()
        val file = File("Ficha_do_Aluno.pdf")
        document.save(file)

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        document.close()
    }

}