//package com.pcgus.ci;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.mail.*;
//import javax.security.auth.login.AppConfigurationEntry;
//import javax.security.auth.login.Configuration;
//import java.io.IOException;
//import java.util.Locale;
//import java.util.Properties;
//
//public class GmailReader {
//
//    private static final Logger log = LogManager.getLogger(ExcelReader.class);
//
//    public String getEmail() throws NoSuchProviderException {
//        String port = null;
//        String userName = null;
//        String password = null;
//        Properties properties = new Properties();
//        properties.put("mail.imap.host","");
//        properties.put("mail.imap.port","");
//
//        properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.imap.socketFactory.fallback","false");
//        properties.setProperty("mail.imap.socketFactory.port",String.valueOf(port));
//
//        Session session = Session.getDefaultInstance(properties);
//        String htmlMessage = null;
//        try{
//            Store store = session.getStore("imap");
//            store.connect(userName, password);
//
//            Folder folderInbox = session.getFolder("INBOX");
//            folderInbox.open(Folder.READ_ONLY);
//
//            Message[] foundMessages = folderInbox.search("ytrf");
//            int count = folderInbox.getMessageCount();
//            Message message = null;
//            String content;
//            int k = 0;
//            System.out.println("Attempt No:"+(k+1));
//            for(int i = count - 1; i>0; i--){
//                message = foundMessages[i];
//                String subject = message.getSubject();
//                content = message.getContent().toString();
//
//                if(subject.contains("keyword")){
//                    System.out.println("Found Message Subject# "+ i + ":"+ subject);
//                    break;
//                }
//                k = k + 1;
//                if(k>=5){
//                    System.out.println("Mail Not Found");
//                }
//            }
//
//            Object o = message.getContent();
//            if(o instanceof  Multipart){
//                System.out.println("**This is a Multipart Message**");
//                Multipart mp = (Multipart) o;
//                System.out.println("**This Multipart Message has "+mp.getCount()+" parts.");
//                for(int j = 0; j<mp.getCount(); j++){
//                    BodyPart b = mp.getBodyPart(j);
//                    if(b.getContentType().contains("multipart")){
//                        mp = (Multipart) b.getContent();
//                        j = 0;
//                        continue;
//                    }
//                    System.out.println("This Content type is"+b.getContentType());
//                    if(!b.getContentType().toLowerCase(Locale.ENGLISH).contains("text/html")){
//                        continue;
//                    }
//
//                    Object o2 = b.getContent();
//                    if(o2 instanceof String){
//                        htmlMessage = o2.toString();
//                    }
//                }
//            }
//            folderInbox.close(false);
//            store.close();
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return htmlMessage;
//    }
//}
