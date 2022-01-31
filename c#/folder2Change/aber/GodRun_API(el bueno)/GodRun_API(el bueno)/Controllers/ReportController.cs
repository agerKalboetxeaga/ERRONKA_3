using AspNetCore.Reporting;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text;
using GodRun_API_el_bueno_.Services;
using GodRun_API_el_bueno_.Models;

namespace GodRun_API_el_bueno_.Controllers
{
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnviroment;
        private readonly IComentsService _comentsService;
        public ReportController(IWebHostEnvironment webHostEnviroment, IComentsService comentsService)
        {
            _webHostEnviroment = webHostEnviroment;
            _comentsService = comentsService;
        }
        public IActionResult PrintIt(List<Partida> partidak, string type)
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            List<Employee> employees = new List<Employee>();
            foreach(var partida in partidak)
            {
                employees.Add(partida.employee);
            }

            string mimtype = "";
            int extension = 1;
            var PATH = $"{_webHostEnviroment.WebRootPath}\\Reports\\Report1.rdlc";

            Dictionary<string, string> parameters = new Dictionary<string, string>();
            parameters.Add("Param1", HttpContext.User.Identity.Name + "entzat opari hau");
            parameters.Add("Param2", type);

            LocalReport localReport = new LocalReport(PATH);
            localReport.AddDataSource("PartidaDataSet", partidak);
            localReport.AddDataSource("EmployeeDataSet", employees);

            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);

            return File(result.MainStream, "application/pdf");
        }



        public IActionResult Index()
        {
            return View();
        }
    }
}
