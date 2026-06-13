| Status  | Nome                  | Significado                             | Exemplo                                   |
| ------- | --------------------- | --------------------------------------- | ----------------------------------------- |
| **200** | OK                    | Requisição executada com sucesso        | Buscar um cliente existente               |
| **201** | CREATED               | Recurso criado com sucesso              | Cadastro de um novo cliente               |
| **204** | NO_CONTENT            | Sucesso, mas sem conteúdo para retornar | Cliente deletado                          |
| **400** | BAD_REQUEST           | Dados enviados incorretamente           | Email inválido ou campo obrigatório vazio |
| **401** | UNAUTHORIZED          | Usuário não autenticado                 | Tentar acessar API sem login              |
| **403** | FORBIDDEN             | Usuário autenticado, mas sem permissão  | Usuário comum tentando acessar área ADMIN |
| **404** | NOT_FOUND             | Recurso não encontrado                  | Buscar cliente com ID inexistente         |
| **409** | CONFLICT              | Conflito de dados                       | Tentar cadastrar email já existente       |
| **500** | INTERNAL_SERVER_ERROR | Erro interno da aplicação               | Exceção não tratada                       |
