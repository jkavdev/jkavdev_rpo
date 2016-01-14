package la.foton.sonar.principal.ui;

import org.sonar.api.web.Footer;

public final class FooterSonar implements Footer {

  @Override
  public String getHtml() {
    return "<p>Footer Example - <em>This is static HTML</em></p>";
  }
}
