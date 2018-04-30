  <html>
  <head>
  <title>Reading List</title>
  </head>
  <body>
        <h2>Lista de usuarios </h2>
        <div th:unless="${#lists.isEmpty(usuarios)}">
              <dl th:each="usuario : ${usuarios}">
                    <dt class="bookHeadline">
                          <span th:text="${usuario.login}">Login</span> by <span
                                th:text="${usuario.senha}">Senha</span> 
   
                    </dt>
              </dl>
        </div>
        <div th:if="${#lists.isEmpty(usuarios)}">
              <p>Nenhum login Cadastrado para esse usuário</p>
        </div>
        <hr />
        <h3>Adicione Login:</h3>
        <form method="POST">
              <label for="login">login:</label> <input type="text" name="login" size="50"></input><br />  
              <label for="senha">senha:</label> <input type="text" name="senha" size="50"></input><br /> 
                     <br /> <input type="submit"></input>
        </form>
  </body>
  </html>