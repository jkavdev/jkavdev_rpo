package br.com.cocodonto.apresentacao.paciente;

//nosso controller
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.service.PacienteService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacienteActionListener implements ActionListener {

    private PacienteFrm frm;
    private PacienteService pacienteService;

    public PacienteActionListener(PacienteFrm frm) {
        this.frm = frm;
        pacienteService = new PacienteService();
        adicionaListener();
    }

    //anexando o listener aos botos do formulario
    public void adicionaListener() {
        frm.getJbAlterar().addActionListener(this);//control + shift + baixo - copia linha
        frm.getJbIncluir().addActionListener(this);
        frm.getJbSalvar().addActionListener(this);
        frm.getJbCancelar().addActionListener(this);
        frm.getJbExcluir().addActionListener(this);
    }

    //habilitando campos
    private void enableButtonsToSaveAction() {
        enableOrDisableButtonsToEdit(true);
    }

    private void disableButtonsToSaveAction() {
        enableOrDisableButtonsToEdit(false);
    }

    private void enableOrDisableButtonsToEdit(boolean enabled) {
        frm.getJbAlterar().setEnabled(!enabled);
        frm.getJbExcluir().setEnabled(!enabled);
        frm.getJbIncluir().setEnabled(!enabled);
        frm.getJbSalvar().setEnabled(enabled);
        frm.getJbCancelar().setEnabled(enabled);
    }

    //acao executada
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Inserir")) {
            inserir();
        } else if (event.getActionCommand().equals("Alterar")) {

        } else if (event.getActionCommand().equals("Salvar")) {
            salvar();
        } else if (event.getActionCommand().equals("Cancelar")) {

        } else if (event.getActionCommand().equals("Excluir")) {
        }

    }

    //primeira acao
    private void inserir() {
        enableButtonsToSaveAction();
    }

    private void salvar() {

        disableButtonsToSaveAction();
    }

    private Paciente formToPaciente() {
        Paciente paciente = new Paciente();
        if (!"".equals(frm.getJlPacienteId().getText())) {
            paciente.setId(Long.parseLong(frm.getJlPacienteId().getText()));
        }
        paciente.setNome(frm.getJtfNome().getText());
        paciente.setCpf(frm.getJtfCpf().getText());
        paciente.setRg(frm.getJrfRg().getText());

        return paciente;
    }
}
