package wildflyswarm.ds.projectstages;

import org.assertj.core.api.Assertions;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@RunWith(Arquillian.class)
public class MyControllerIT {

  @Deployment(testable = false)
  public static JAXRSArchive createDeployment() {
    return ShrinkWrap.create(JAXRSArchive.class).addClass(MyController.class);
  }

  @ArquillianResource
  private URI deploymentUri;

  @Test
  public void test() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(deploymentUri);

    Response response = target.request(MediaType.APPLICATION_JSON).get();

    Assertions.assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    Assertions.assertThat(response.readEntity(String.class).contains("org.jboss.jca.adapters.jdbc.jdk7.WrappedConnectionJDK7"));
  }

}