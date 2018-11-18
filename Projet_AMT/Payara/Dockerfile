FROM payara/server-full

RUN ${PAYARA_PATH}/bin/asadmin start-domain domain1 && \
  ${PAYARA_PATH}/bin/asadmin --user=admin --passwordfile=/opt/pwdfile create-jdbc-connection-pool \
    --datasourceclassname com.mysql.cj.jdbc.MysqlDataSource \
    --restype javax.sql.DataSource \
    --property user=root:password=password:DatabaseName=Projet_AMT:ServerName=db:port=3306:useSSL=false Projet_AMT && \
    ${PAYARA_PATH}/bin/asadmin --user=admin --passwordfile=/opt/pwdfile create-jdbc-resource \
    --connectionpoolid Projet_AMT jdbc/Projet_AMT && \
    ${PAYARA_PATH}/bin/asadmin --user=admin --passwordfile=/opt/pwdfile create-javamail-resource --mailhost smtp.gmail.com --mailuser gamify.ultimate --fromaddress gamify.ultimate@gmail.com --storeprotocol=imap --storeprotocolclass=com.sun.mail.imap.IMAPStore --transprotocol=smtp --transprotocolclass=com.sun.mail.smtp.SMTPTransport --password Password123@ --auth true --property mail.smtp.auth=true:mail.smtp.user=gamify.ultimate@gmail.com:mail.smtp.password=gamify.ultimate:mail.smtp.port=465:mail.smtp.socketFactory.port=465:mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory java/mailapp && \
  ${PAYARA_PATH}/bin/asadmin --user=admin --passwordfile=/opt/pwdfile restart-domains domain1

COPY Projet_AMT.war ${AUTODEPLOY_DIR}
COPY Driver /opt/payara5/glassfish/domains/domain1/lib
