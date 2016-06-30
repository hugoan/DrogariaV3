package br.com.drogariav3.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogariav3.util.HibernateUtil;


public class GenericDAO<Entidade> {
	
	//Comando para capturar a classe. Este comando é necessário para apoiar os algoritimos de pesquisa e listar
	
	private Class<Entidade> classe;
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	//Fim do comando

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}

			throw erro;
		} finally {
			sessao.close();
		}
	}
}
