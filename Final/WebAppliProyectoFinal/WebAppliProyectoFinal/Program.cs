using WebAppliProyectoFinal.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();
builder.Services.Add(new ServiceDescriptor(typeof(IUsuario),
                     new UsuarioRepository()));
builder.Services.Add(new ServiceDescriptor(typeof(IDoctor),
                     new DoctorRepository()));
builder.Services.Add(new ServiceDescriptor(typeof(IPaciente),
                     new PacienteRepository()));
builder.Services.Add(new ServiceDescriptor(typeof(IPortada),
                     new PortadaRepository()));

builder.Services.AddSession(options =>
{
    options.IdleTimeout = TimeSpan.FromSeconds(3600);
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Usuario}/{action=Index}/{id?}");

app.Run();
