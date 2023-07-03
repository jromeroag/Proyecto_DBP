using System;
using System.Collections.Generic;

namespace WebAppliProyectoFinal.Models;

public partial class Citum
{
    public int Idci { get; set; }

    public int Iddoc { get; set; }

    public int Idpa { get; set; }

    public DateTime Fecin { get; set; }

    public DateTime Fecfi { get; set; }

    public virtual Doctor IddocNavigation { get; set; } = null!;

    public virtual Paciente IdpaNavigation { get; set; } = null!;
}
