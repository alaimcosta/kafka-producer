package unifesspa.kafka.producer;

import unifesspa.kafka.producer.eventos.ProdutorEventos;

public class AplicacaoProducer {
    public static void main(String[] args) {
        AplicacaoProducer aplicacao = new AplicacaoProducer();
        aplicacao.iniciar();

    }

    private void iniciar() {
        System.out.println("Inicializando aplicação");
        ProdutorEventos produtor = new ProdutorEventos();
        produtor.executar();

    }
}
