package wildflyswarm.ds.projectstages;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@ApplicationScoped
@Path("/")
public class MyController {

  @Resource
  private DataSource ds;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() throws SQLException {
    return String.format("{\"conn\": \"%s\"}", ds.getConnection());
  }

}
