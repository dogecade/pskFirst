package first.rest;

import first.entities.Product;
import first.persistence.jpa.ProductsDAO;
import first.contract.*;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/product")
public class ProductController {
    @Inject
    @Getter
    @Setter
    private ProductsDAO productsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Product product = productsDAO.findOne(id);
        if (product == null) {
            System.out.println("nera tokio");

            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ProductDTO productDto = new ProductDTO();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());

        return Response.ok(productDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response add(
            ProductDTO productData) {

        Product newProduct = new Product();
        newProduct.setName(productData.getName());
        newProduct.setPrice(productData.getPrice());

        productsDAO.persist(newProduct);

        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer productId,
            ProductDTO productData) {

        try {

            Product existingProduct = productsDAO.findOne(productId);

            Thread.sleep(6000);

            if (existingProduct == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingProduct.setName(productData.getName());
            existingProduct.setPrice(productData.getPrice());

            productsDAO.update(existingProduct);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        } catch (InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
