using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public class CitaRepository:ICita
    {
        private PROYECT conexion = new PROYECT();

        public void add(Citum obj)
        {
            try
            {
                conexion.Cita.Add(obj);
                conexion.SaveChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine("Ocurrio un error al grabar los datos de la Cita!", e.Message);
            }
        }

        public Citum edit(int id)
        {

            var obj = (from tCit in conexion.Cita
                       where tCit.Idci == id
                       select tCit).Single();
            return obj;
        }

        public void editDetails(Citum obj)
        {
            var objModificar = (from tCit in conexion.Cita where tCit.Iddoc == obj.Iddoc select tCit).Single();
            objModificar.Fecin = obj.Fecin;
            objModificar.Fecfi = obj.Fecin;
          


            conexion.SaveChanges();
        }

        public IEnumerable<Citum> GetCitas()
        {
            return conexion.Cita;
        }

        public void remote(int id)
        {
            var obj = (from tbCi in conexion.Cita
                       where tbCi.Idci == id
                       select tbCi).Single();
            conexion.Remove(obj);
            conexion.SaveChanges();
        }
    }
}
