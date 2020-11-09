package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //save as container in spring
public class MemberController {

    private final MemberService memberService;

    //About dependency injection

    //1) field injection, not good, not flexible.
    //@Autowired private final MemberService memberService;

    //2)construction injection, most encourage.
    @Autowired // automatically get container which was saved
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //3)setter injection, always need to set public. might take at risk
    //@Autowired // automatically get container which was saved
    //public void setMemberController(MemberService memberService){
    //    this.memberService = memberService;
    //}


    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }


    @PostMapping("members/new")
    public String create(MemberForm form, Model model){
        Member member = new Member();
        member.setName(form.getName());
        member.setSalary(form.getSalary());
        memberService.join(member);

        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    @GetMapping("/members/delete")
    public String delete(Model model, @RequestParam Long Id){

        memberService.deleteById(Id);

        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    @PostMapping("/members/update")
    public String update(Model model, Member member ){

        memberService.updateById(member);

        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
