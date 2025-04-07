let input_paciente = document.getElementById("input-paciente")
let btn_close = document.getElementById("btn-close")
let modal = document.getElementById("modal")
let fundo = document.getElementById("fundo")
let id_paciente = document.getElementById("id-paciente")

let btnPesqPaciente = document.getElementById("pesquisar-paciente")


input_paciente.addEventListener("keypress", mostraModal)
btn_close.addEventListener("click", fecharModal)
btnPesqPaciente.addEventListener("click", mostraModal)


function fecharModal(){
    modal.style.display = "none"
    fundo.style.display = "none"
}

function pegaValor(){
    console.log(input_paciente.value)
}

function mostraModal(){
    console.log(modal)
    input_paciente.blur()
    let campoFiltraPaciente = document.getElementById("filtra-paciente")
    campoFiltraPaciente.focus()
    modal.style.display = "block"
    fundo.style.display = "flex"

}

function capturaPaciente(id, nome){
    console.log(id)
    id_paciente.value = id
    input_paciente.value = nome
    fecharModal()
}

document.getElementById("filtra-paciente").addEventListener("input", function () {
    var textodigitado = this.value.toLowerCase()
    let valor_linhas_tabela = document.querySelectorAll('#table-pacientes tbody tr')

    valor_linhas_tabela.forEach(function (linha){
        var valorLinha = linha.textContent.toLowerCase();
        linha.style.display = valorLinha.includes(textodigitado) ? '' : 'none'
    })
})