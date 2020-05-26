package first.usecases;

import lombok.Getter;
import first.entities.Producer;
import first.entities.Product;
import first.entities.Receiver;
import first.persistence.jpa.ProducersDAO;
import first.persistence.jpa.ProductsDAO;
import first.persistence.jpa.ReceiversDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
@RequestScoped
public class PersistenceController implements Serializable {
    @Inject
    private ProducersDAO producersDAO;
    @Inject
    private ProductsDAO productsDAO;
    @Inject
    private ReceiversDAO receiversDAO;

    @Inject
    private INumberGenerator numberGenerator;

    @Getter
    private  Producer producer = new Producer();
    @Getter
    private Product product = new Product();
    @Getter
    private Product productToAssign = new Product();
    @Getter
    private Receiver receiver = new Receiver();

    @Getter
    private List<Producer> producers;
    @Getter
    private List<Product> products;
    @Getter
    private List<Receiver> receivers;

    @PostConstruct
    public void init(){
        this.producers = producersDAO.loadAll();
        this.products = productsDAO.loadAll();
        this.receivers = receiversDAO.loadAll();
    }

    @Transactional
    public void createNewProducer(){
        producer.setId(null);
        producersDAO.persist(producer);
    }

    @Transactional
    public void createNewProduct(){
        List<Receiver> receiverList = new ArrayList();

        producersDAO.findOne(producer.getId());
        product.setProducer(producer);
        product.setReceiverList(receiverList);

        productsDAO.persist(product);
    }

    @Transactional
    public void createNewReceiver(){
        List<Product> productList = new ArrayList();

        receiver.setId(null);
        receiver.setProductList(productList);

        receiversDAO.persist(receiver);
    }

    @Transactional
    public void assignProductToReceiver(){
        Product productToAssignInstance = productsDAO.findOne(productToAssign.getId());
        Receiver receiverToAssign = receiversDAO.findOne(receiver.getId());

        List<Product> productList = receiverToAssign.getProductList();
        productList.add(productToAssignInstance);

        receiverToAssign.setProductList(productList);
    }

    @Transactional
    public void deleteProduct(Integer id) {
        try {
            Thread.sleep(3000);

            productsDAO.delete(id);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } {

        }
    }

    @Transactional
    public int getNumber() {
        return numberGenerator.generateInt();
    }
}
