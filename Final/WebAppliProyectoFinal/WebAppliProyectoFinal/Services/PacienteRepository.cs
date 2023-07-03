using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public class PacienteRepository : IPaciente
    {
        private PROYECT conexion = new PROYECT();

        public void add(Paciente obj)
        {
            try
            {
                conexion.Pacientes.Add(obj);
                conexion.SaveChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine("Ocurrio un error al grabar los datos del Paciente!", e.Message);
            }
        }

        public Paciente edit(int id)
        {
            var obj = (from tPa in conexion.Pacientes
                       where tPa.Idpa == id
                       select tPa).Single();
            return obj;
        }

        public void EditDatails(Paciente paciente)
        {
            var objModificar = (from tPa in conexion.Pacientes where tPa.Idpa == paciente.Idpa select tPa).Single();
            objModificar.Nompa = paciente.Nompa;
            objModificar.Apepa = paciente.Apepa;
            objModificar.Corpa = paciente.Corpa;
            objModificar.Dnipa = paciente.Dnipa;
            objModificar.Celpa = paciente.Celpa;


            conexion.SaveChanges();
        }

        public IEnumerable<Paciente> GetAllPacientes()
        {
            return conexion.Pacientes;
        }

        public void remove(int id)
        {
            var obj = (from tPa in conexion.Pacientes
                       where tPa.Idpa == id
                       select tPa).Single();
            conexion.Remove(obj);
            conexion.SaveChanges();
        }
    }
}
