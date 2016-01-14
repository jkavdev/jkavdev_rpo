package la.foton.sonar.principal;

import java.util.Arrays;
import java.util.List;

import la.foton.sonar.inicializador.Inicializador;
import la.foton.sonar.principal.batch.LInesMethodsSensor;
import la.foton.sonar.principal.batch.LinesMethodsDecorator;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

/**
 * This class is the entry point for all extensions
 */
@Properties({
  @Property(
    key = PluginFotonAnalise.MY_PROPERTY,
    name = "Plugin Property",
    description = "A property for the plugin",
    defaultValue = "Hello World!"),
  @Property(
			key = PluginFotonAnalise.GROUPID,
			name = "project.groupid",
			description = "GroupId do Projeto.",
			defaultValue = "GroupID")})
public final class PluginFotonAnalise extends SonarPlugin {

  public static final String MY_PROPERTY = "sonar.example.myproperty";
  public static final String GROUPID = "project.groupid";

  // This is where you're going to declare all your SonarQube extensions
  @Override
  public List getExtensions() {
    return Arrays.asList(
      // Definitions
      MetricasSonar.class,  Inicializador.class,

      // Batch
      LInesMethodsSensor.class, LinesMethodsDecorator.class);

      // UI
     // ExampleFooter.class, ExampleRubyWidget.class);
  }
}
