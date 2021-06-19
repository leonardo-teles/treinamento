import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cliente-pesquisar',
  templateUrl: './cliente-pesquisar.component.html',
  styleUrls: ['./cliente-pesquisar.component.css']
})
export class ClientePesquisarComponent {

  clientes = [
  { nome: 'Sarah Maya Isabelly Lima', cpf: '617.740.784-65', email: 'sarah.lima@gmail.com', ativo: true, observacao: 'A má utilização dos dados aqui gerados é de total responsabilidade do usuário.' },
  { nome: 'Severino Oliver Tiago da Mota', cpf: '965.193.992-30', email: 'severino.mota@gmail.com', ativo: false, observacao: '' },
  { nome: 'Marli Eloá de Paula', cpf: '790.315.592-02', email: 'marli.paula@gmail.com', ativo: false, observacao: 'A má utilização dos dados aqui gerados é de total responsabilidade do usuário.' },
  { nome: 'Sarah Regina Kamilly Barbosa', cpf: '519.785.240-21', email: 'sarah.barbosa@gmail.com', ativo: true, observacao: 'A má utilização dos dados aqui gerados é de total responsabilidade do usuário.' },
  { nome: 'Aline Giovana Silvana Souza', cpf: '316.188.218-06', email: 'aline.souza@gmail.com', ativo: false, observacao: '' },
  { nome: 'Vanessa Eloá Louise Nogueira', cpf: '156.053.750-75', email: 'vanessa.elao@gmail.com', ativo: true, observacao: '' },
  { nome: 'Francisco Pedro Henrique Augusto Rezende', cpf: '904.630.700-03', email: 'fransisco.rezende@gmail.com', ativo: true, observacao: 'A má utilização dos dados aqui gerados é de total responsabilidade do usuário.' }
];

}
