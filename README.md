# Desafio-Shadow-8
Desafio:  Demanda: Construir dois serviços que serão responsáveis por determinadas tarefas na conta bancária dos cliente de um banco
* Cadastrar novos clientes na base de dados do banco
* Realizar todas as operações básicas de um banco (saldo, extrato, depósito, saque e transferência)
* Cada cliente tem um número gratuito de saques mensal, e após isso, é cobrada uma taxa por cada saque

O número gratuito de saques é informado no momento do cadastro da conta do cliente, de acordo com o tipo da conta

    - Conta tipo pessoa física, terá 5 saques gratuitos por mês, após isso deve ser cobrado R$10 por cada saque
    
    - Conta tipo pessoa jurídica terá 50 saques gratuitos por mês, após isso deve ser cobrado R$10 por cada saque
    
    - Conta governamental terá 250 saques gratuitos por mês, após isso deve ser cobrado R$20 por cada saque
    
    - O valor adicional do saque deve ser decrescido do valor do saldo do cliente (Saque de 100 reais, ao ser cobrado 5 reais de taxa, o cliente deve ter no mínimo 105 reais de saldo)
    
 Funcionalidades do serviço 1 (responsável pelo controle da conta bancária do usuário): 
 
    1 - Efetuar o cadastro de novos clientes
    
        * um cliente pode ter mais de uma conta
	
        * cadastrar dados básicos do cliente (nome, cpf, telefone e endereço)
	
    2 - Efetuar cadastro da conta
    
        * agencia
	
        * numero da conta
	
        * tipo da conta 
	
        * digito verificador
	
        * cliente (cpf)   
	
    3 - Efetuar operações de consulta de saldo e extrato, realizar saque e transferência 
	
    4 - Receber a entrada de informações para cadastrar a quantidade de saques gratuitos por mês. (operação assíncrona)
    
    5 - Apenas saques, verificar a quantidade de saques grátis, caso tenha disponibilidade, não cobrar taxa e notificar (mensageria) o uso ao serviço responsável 
    
    
    6 - Adicionar artefatos e implementações aprendidas em outros desafios. Funcionalidades do serviço 2 (responsável pelo controle da quantidade de saques gratuitos):
    
    1 - criar o limite de saque gratuito por mês para o cliente
    
    2 - controlar o uso, tanto na base de dados.  Requisitos técnicos na construção dos serviços:
    
- Implementar arquitetura de micro serviços - Clean arch

- Utilizar base de dados SQL para armazenar os dados

- Utilizar KAFKA para serviços de mensageria

- Utilizar Java 11 

- Utilizar Boas práticas de programação (clean code)
