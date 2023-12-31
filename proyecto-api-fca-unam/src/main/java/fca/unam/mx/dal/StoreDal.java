package fca.unam.mx.dal;

import fca.unam.mx.dao.StoreDao;
import fca.unam.mx.dto.ClientDto;
import fca.unam.mx.dto.ProductDto;
import fca.unam.mx.dto.ResponseDto;
import fca.unam.mx.services.JdbiService;
import org.jboss.logging.Logger;
import org.jdbi.v3.core.Jdbi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StoreDal {

    private static final Logger LOGGER = Logger.getLogger(StoreDal.class);

    @Inject
    JdbiService jdbiService;

    public ResponseDto<List<ProductDto>> getProducts() {
        ResponseDto<List<ProductDto>> responseDto = new ResponseDto<>();
        responseDto.setSuccess(true);

        Jdbi jdbi = jdbiService.getInstance();
        List<ProductDto> products = jdbi.withExtension(StoreDao.class, dao -> dao.getProducts());

        responseDto.setData(products);
        return responseDto;
    }

    public ResponseDto<List<ClientDto>> getClients() {
        ResponseDto<List<ClientDto>> responseDto = new ResponseDto<>();
        responseDto.setSuccess(true);

        Jdbi jdbi = jdbiService.getInstance();
        List<ClientDto> clients = jdbi.withExtension(StoreDao.class, dao -> dao.getClients());

        responseDto.setData(clients);
        return responseDto;
    }

    public ResponseDto<String> addProduct(final ProductDto productDto) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setSuccess(false);

        Jdbi jdbi = jdbiService.getInstance();
        jdbi.useExtension(StoreDao.class, dao -> {
            dao.addProduct(productDto);
            responseDto.setSuccess(true);
            responseDto.setData("ok");
        });

        return responseDto;
    }
}
