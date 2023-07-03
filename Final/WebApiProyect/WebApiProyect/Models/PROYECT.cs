using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace WebApiProyect.Models;

public partial class PROYECT : DbContext
{
    public PROYECT()
    {
    }

    public PROYECT(DbContextOptions<PROYECT> options)
        : base(options)
    {
    }

    public virtual DbSet<Citum> Cita { get; set; }

    public virtual DbSet<Doctor> Doctors { get; set; }

    public virtual DbSet<Paciente> Pacientes { get; set; }

    public virtual DbSet<Usuario> Usuarios { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=sql5106.site4now.net;Initial Catalog=db_a9b69f_basedbp;User ID=db_a9b69f_basedbp_admin;Password=admin123;Integrated Security=False;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Citum>(entity =>
        {
            entity.HasKey(e => e.Idci).HasName("PK__CITA__B87D80B8288BF8D8");

            entity.ToTable("CITA");

            entity.Property(e => e.Idci).HasColumnName("IDCI");
            entity.Property(e => e.Fecfi)
                .HasColumnType("date")
                .HasColumnName("FECFI");
            entity.Property(e => e.Fecin)
                .HasColumnType("date")
                .HasColumnName("FECIN");
            entity.Property(e => e.Iddoc).HasColumnName("IDDOC");
            entity.Property(e => e.Idpa).HasColumnName("IDPA");

            entity.HasOne(d => d.IddocNavigation).WithMany(p => p.Cita)
                .HasForeignKey(d => d.Iddoc)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CITA__IDDOC__4F7CD00D");

            entity.HasOne(d => d.IdpaNavigation).WithMany(p => p.Cita)
                .HasForeignKey(d => d.Idpa)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CITA__IDPA__5070F446");
        });

        modelBuilder.Entity<Doctor>(entity =>
        {
            entity.HasKey(e => e.Iddoc).HasName("PK__DOCTOR__93E6A834E9781E0A");

            entity.ToTable("DOCTOR");

            entity.Property(e => e.Iddoc).HasColumnName("IDDOC");
            entity.Property(e => e.Apedoc)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("APEDOC");
            entity.Property(e => e.Celdoc).HasColumnName("CELDOC");
            entity.Property(e => e.Espdoc)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("ESPDOC");
            entity.Property(e => e.Nomdoc)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("NOMDOC");
        });

        modelBuilder.Entity<Paciente>(entity =>
        {
            entity.HasKey(e => e.Idpa).HasName("PK__PACIENTE__B87C5B0E41FC946C");

            entity.ToTable("PACIENTE");

            entity.Property(e => e.Idpa).HasColumnName("IDPA");
            entity.Property(e => e.Apepa)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("APEPA");
            entity.Property(e => e.Celpa).HasColumnName("CELPA");
            entity.Property(e => e.Corpa)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("CORPA");
            entity.Property(e => e.Dnipa).HasColumnName("DNIPA");
            entity.Property(e => e.Nompa)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("NOMPA");
        });

        modelBuilder.Entity<Usuario>(entity =>
        {
            entity.HasKey(e => e.Idusu).HasName("PK__USUARIO__A6480A5382167B8C");

            entity.ToTable("USUARIO");

            entity.Property(e => e.Idusu).HasColumnName("IDUSU");
            entity.Property(e => e.Clausu)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("CLAUSU");
            entity.Property(e => e.Nomusu)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("NOMUSU");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
