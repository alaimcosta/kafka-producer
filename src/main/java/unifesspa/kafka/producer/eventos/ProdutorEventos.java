package unifesspa.kafka.producer.eventos;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

public class ProdutorEventos {

    private final Producer<String, String> producer;


    public ProdutorEventos(){
        producer = criarProducer();
    }

    //responsavel por criar o produtor
    private Producer<String, String> criarProducer(){
        if(producer != null){
            return producer;
        }
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        return new KafkaProducer<String, String>(properties);

    }

    public void executar() {

        String chave = UUID.randomUUID().toString();
        String msg = "Olá Unifesspa";
        //concatenar msg e chave
        msg += "|" + chave;
        msg += "Nova mensagem";

        //Envio da mensagem
        //selecionar os topicos
        System.out.println("Iniciando envio da mensagem");
        ProducerRecord<String, String> record = new ProducerRecord<String, String>( "RegistroEvento", chave, msg); //registro
        producer.send(record);

        producer.flush();//para garantir que foi enviada
        producer.close();
        System.out.println("Mensagem enviada com sucesso ["+ msg+ "]");
    }
}
