package org.program.MVC_Spring; 
import org.program.MVC_Spring.model.QuestionPaper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("AddView")
    public String AddView(){
        return "AddView";
    }

    @RequestMapping("QuestionPaperView")
    public String QPView(){
        return "QuestionPaperView";
    }

//  Approach-1.
//    @RequestMapping("/add")
//    public String add(HttpServletRequest rq, HttpSession session){
//        int num1=Integer.parseInt(rq.getParameter("Num1"));
//        int num2=Integer.parseInt(rq.getParameter("Num2"));
//        int sum=num1+num2;
//        session.setAttribute("addResult",sum);
//        System.out.println("Sum is : "+sum);
//        return "sumRes";
//    }

//  Approach-2.
//    @RequestMapping("add")
//    public String add(@RequestParam("Num1") int n1,@RequestParam("Num2") int n2, HttpSession session){
//        int sum=n1+n2;
//        session.setAttribute("addResult",sum);
//        return "sumRes";
//    }

//  Approach-3.
//    @RequestMapping("add")
//    public String add(@RequestParam("Num1") int n1, @RequestParam("Num2") int n2, Model model){
//        int sum=n1+n2;
//        model.addAttribute("addResult",sum);
//        return "sumRes";
//    }

//  Approach-4.
    @RequestMapping("add")
      public ModelAndView add(@RequestParam("Num1") int n1, @RequestParam("Num2") int n2, ModelAndView modelView){
          int sum=n1+n2;
          modelView.addObject("addResult",sum);
          modelView.setViewName("sumRes");
          return modelView;
      }

//  Approach-1.
//    @RequestMapping("addQue")
//      public ModelAndView addQuestion(@RequestParam("id") int qID, @RequestParam("question") String qQes, ModelAndView modelView){
//          QuestionPaper qp=new QuestionPaper();
//          qp.setId(qID);
//          qp.setQuestion(qQes);
//          modelView.addObject("questionPaper",qp);
//          modelView.setViewName("QuePaperRes");
//          return modelView;
//      }

//  Approach-2.
      @RequestMapping("addQue")
      public String addQuestion(@ModelAttribute QuestionPaper questionPaper){
            return "QuePaperRes";
      }
}
