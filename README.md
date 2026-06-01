🚗 API Locadora de Veículos
Esta é uma API REST desenvolvida para o gerenciamento de uma locadora de veículos. O sistema permite o cadastro de carros, clientes, gerenciamento de aluguéis, devoluções e controle de estoque de frotas.

🛠️ Tecnologias Utilizadas
Java (Versão utilizada 21)
Spring Boot (Web, Dados JPA, Validação)
Banco de Dados: ( H2)
Ferramenta de Build: Maven/Gradle
📌 Checklist de Funcionalidades
Abaixo está o status do desenvolvimento das principais funcionalidades da API:

Cadastro e gerenciamento de veículos.
Cadastro e gerenciamento de clientes.
Criação e fluxo de contratos de locação (Aluguel).
Cálculo sonoro de valores baseados em diários.
Retorno/Devolução de veículo com verificação de pendências.
Autenticação e segurança com Spring Security & JWT.
Documentação dos endpoints com Swagger/OpenAPI.
(Nota: Para marcar uma tarefa como concluída, troque o [ ]por [x])

🚘 Veículos Cadastrados (Modelos de Exemplo)
A API categoriza e gerencia os veículos com base em suas especificações. Veja abaixo o formato e os tipos de veículos suportados pelo sistema:

Categoria	Modelo	Marca	Ano	Placa	Valor Diário	Status
SUV	Bússola	Jipe	2024	ABC-1234	R$ 250,00	Disponível
Sedan	Corola	Toyota	2023	XYZ-5678	R$ 180,00	Alugado
Chocar	Ônix	Chevrolet	2024	KJB-9988	R$ 120,00	Disponível
Elétrico	Golfinho	BYD	2025	EVX-4411	R$ 220,00	Em Manutenção
Estrutura de Dados do Veículo (JSON)
Quando você faz uma requisição para a API, os dados do veículo seguem este padrão:

{
  "id": 1,
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2023,
  "placa": "XYZ-5678",
  "categoria": "SEDAN",
  "valorDiaria": 180.00,
  "status": "DISPONIVEL"
