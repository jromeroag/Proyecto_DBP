using WebApiProyect.Models;

namespace WebAppliProyectoFinal.Services
{
    public interface IPaciente
    {
   
        void add(Paciente obj);
        void remove(int id);
        Paciente edit(int id);
        void EditDatails(Paciente paciente);
        IEnumerable<Paciente> GetAllPaciente();
    }
}
