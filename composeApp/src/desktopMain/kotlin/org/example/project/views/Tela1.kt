package org.example.project.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.models.formaPagamentoList
import org.example.project.models.tratamentoAgua
import org.example.project.viewModels.CampoTexto
import org.example.project.viewModels.SecaoFormulario

@Composable
fun Tela1() {
    var nomeCliente by remember { mutableStateOf("") }
    var cnpj by remember { mutableStateOf("") }
    var nomeComercial by remember { mutableStateOf("") }
    var siteEmpresa by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var emailEmpresa by remember { mutableStateOf("") }
    var nomeRepresentante by remember { mutableStateOf("") }
    var foneRepresentante by remember { mutableStateOf("") }
    var emailRepresentante by remember { mutableStateOf("") }
    var nomeLaboratorio by remember { mutableStateOf("") }
    var siglaLaboratorio by remember { mutableStateOf("") }
    var nomeCoordenador by remember { mutableStateOf("") }
    var cpfCoordenador by remember { mutableStateOf("") }
    var tecnico1 by remember { mutableStateOf("") }
    var cpfTecnico1 by remember { mutableStateOf("") }
    var tecnico2 by remember { mutableStateOf("") }
    var cpfTecnico2 by remember { mutableStateOf("") }
    var detalhesDoServico by remember { mutableStateOf("") }
    var dataInicio by remember { mutableStateOf("") }
    var dataTermino by remember { mutableStateOf("") }
    var totalDiasTrabalhado  by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }
    var desconto by remember { mutableStateOf("") }
    val formaDePagamento = remember { mutableStateListOf<String>() }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecaoFormulario("Dados do Contratante") {
            CampoTexto(nomeCliente, { nomeCliente = it }, "Razão Social / Nome Completo")
            CampoTexto(cnpj, { cnpj = it }, "CNPJ / CPF")
            CampoTexto(nomeComercial, { nomeComercial = it }, "Nome Comercial / Projeto")
            CampoTexto(siteEmpresa, { siteEmpresa = it }, "Site da Empresa")
            CampoTexto(endereco, { endereco = it }, "Endereço Completo")
            CampoTexto(telefone, { telefone = it }, "DDD / Telefones")
            CampoTexto(emailEmpresa, { emailEmpresa = it }, "E-mail da Empresa")
            CampoTexto(nomeRepresentante, { nomeRepresentante = it }, "Nome do Representante")
            CampoTexto(foneRepresentante, { foneRepresentante = it }, "Fone do Representante")
            CampoTexto(emailRepresentante, { emailRepresentante = it }, "E-mail do Representante")
        }

        SecaoFormulario("Dados do Laboratório Prestador do Serviço") {
            CampoTexto(nomeLaboratorio, { nomeLaboratorio = it }, "Nome do Laboratório")
            CampoTexto(siglaLaboratorio, { siglaLaboratorio = it }, "Sigla ou Logo")
            CampoTexto(nomeCoordenador, { nomeCoordenador = it }, "Nome do Coordenador")
            CampoTexto(cpfCoordenador, { cpfCoordenador = it }, "CPF do Coordenador")
            CampoTexto(tecnico1, { tecnico1 = it }, "Nome do Técnico 1")
            CampoTexto(cpfTecnico1, { cpfTecnico1 = it }, "CPF do Técnico 1")
            CampoTexto(tecnico2, { tecnico2 = it }, "Nome do Técnico 2")
            CampoTexto(cpfTecnico2, { cpfTecnico2 = it }, "CPF do Técnico 2")
        }

        SecaoFormulario("Dados do Serviço") {
            CampoTexto(detalhesDoServico, { detalhesDoServico = it }, "Descrever a necessidade do demandante, serviços a serem executados e resultados a serem entregues")
            CampoTexto(dataInicio, { dataInicio = it }, "Data de Inicio")
            CampoTexto(dataTermino, { dataTermino = it }, "Data de Termino")
            CampoTexto(totalDiasTrabalhado, { totalDiasTrabalhado = it }, "Total de dias trabalhados")
        }

        SecaoFormulario("Do Pagamento") {
            CampoTexto(valor, { valor = it }, "Valor (R$)")
            CampoTexto(desconto, { desconto = it }, "Desconto de até 20%")
        }

        Text("Forma de Pagamento")
        formaPagamentoList.forEach { opcao ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = opcao in formaDePagamento,
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            formaDePagamento.add(opcao)
                        } else {
                            formaDePagamento.remove(opcao)
                        }
                    }
                )
                Text(opcao)
            }
        }

//        Spacer(modifier = Modifier.height(30.dp))
//        Button(onClick = { /* salvar ou avançar */ }) {
//            Text("Salvar")
//        }
    }
}

