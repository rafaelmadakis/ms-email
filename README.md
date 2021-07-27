# ms-email

Microservice para envio de email atraves de smtp do gmail

Para teste configura o application.properties com seu email remetente e senha de 16 digitos, para gerar a senha siga o tutorial em https://support.google.com/accounts/answer/185833
No Postman a estrutura Json a ser enviado pelo endpoint: http://localhost:8081/sending-email é a seguinte: 
 
 {
    "ownerRef": "xxxxx",
    "emailFrom" : "xxxxxxxxxxxx@gmail.com",
    "emailTo" : "xxxxxxxxxxxxxxxxxxxxxx@gmail.com",
    "subject" : "Teste de envio de email",
    "text" : "Segundo Envio de email através de microserviço JAVA"
}
