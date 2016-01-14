package la.foton.sonar.principal;

import java.util.Arrays;
import java.util.List;


import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;


public final class MetricasSonar implements Metrics {

  public static final Metric<Double> QTD_LINHAS_METODOS = new Metric.Builder("qtdLinhas", "QtdLinhas", Metric.ValueType.DATA)
    .setDescription("Quantidade de linhas por Metodo")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(CoreMetrics.DOMAIN_GENERAL)
    .create();
  
  @Override
  public List<Metric> getMetrics() {
    return Arrays.<Metric>asList(QTD_LINHAS_METODOS);
  }
}
