using WebApiProyect.Models;

namespace WebAppliProyectoFinal.Services
{
    public class DoctorRepository : IDoctor
    {
        private PROYECT conexion = new PROYECT();
        public void add(Doctor obj)
        {
            try
            {
                conexion.Doctors.Add(obj);
                conexion.SaveChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine("Ocurrio un error al grabar los datos del Doctor!", e.Message);
            }
        }

        public Doctor edit(int id)
        {
            var obj = (from tDoc in conexion.Doctors
                       where tDoc.Iddoc == id
                       select tDoc).Single();
            return obj;
        }

        public void editaDetails(Doctor obj)
        {
            var objModificar = (from tDoc in conexion.Doctors where tDoc.Iddoc == obj.Iddoc select tDoc).Single();
            objModificar.Nomdoc = obj.Nomdoc;
            objModificar.Apedoc = obj.Apedoc;
            objModificar.Espdoc = obj.Espdoc;
            objModificar.Celdoc = obj.Celdoc;
       


            conexion.SaveChanges();
        }

        public IEnumerable<Doctor> GetAllDoctor()
        {
            return conexion.Doctors;
        }

      

        public void remove(int id)
        {
            var obj = (from tbDoc in conexion.Doctors
                       where tbDoc.Iddoc == id
                       select tbDoc).Single();
            conexion.Remove(obj);
            conexion.SaveChanges();
        }
    }
}
