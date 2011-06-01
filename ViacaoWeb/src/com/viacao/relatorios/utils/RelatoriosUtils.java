package com.viacao.relatorios.utils;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatoriosUtils {

	private static RelatoriosUtils instance = null;
	
	public static RelatoriosUtils getInstance() {
		if (instance == null) {
			instance = new RelatoriosUtils();
		}
		return instance;
	}


	public byte[] getReportFile (String caminhoComNome, Map parameterMap,Collection dados) throws JasperRelatorioVazioException, JRException{

		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(dados);
		InputStream reportFile = this.getClass().getResourceAsStream(caminhoComNome);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile, parameterMap,jrbcds);

		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}
