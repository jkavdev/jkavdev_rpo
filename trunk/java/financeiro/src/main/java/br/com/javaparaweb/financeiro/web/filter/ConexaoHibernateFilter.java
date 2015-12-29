package br.com.javaparaweb.financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.javaparaweb.financeiro.util.HibernateUtil;

//qual o tipo de requisicao esta classe vai interceptar
//no caso todas as .jsf
@WebFilter(urlPatterns={"*.jsf"})
public class ConexaoHibernateFilter implements Filter{
	
	private SessionFactory sf;
	
	
	//metodo a ser executado quando o app for iniciado, 
	//colocado no ar
	
	//criacao da sessao do hibernate,
	//que servira para todas a requisicoes
	@Override
	public void init(FilterConfig config) throws ServletException {
		sf = HibernateUtil.getSessionFactory();
	}
	
	//onde a requisicao e interceptada
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		Session currentSession = this.sf.getCurrentSession();
		
		Transaction transaction = null;
		
		try{
			//sera executando antes de qualquer processamento do sistema
			//iniciando uma transacao no banco de dados
			transaction = currentSession.beginTransaction();
			
			//passando a execucao normal do sistema
			chain.doFilter(req, resp);
			
			//processamento ja foi realizado
			
			//sera realizado o commit
			transaction.commit();
			//e fechamento da sessao
			if(currentSession.isOpen()){
				currentSession.close();
			}
		}catch(Throwable e){
			//caso algum erro
			//faz o rollback
			try{
				if(transaction.isActive()){
					transaction.rollback();
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
	}

	//executado quando o app e desativado, 
	//tirado do ar
	@Override
	public void destroy() {
		
	}


}
