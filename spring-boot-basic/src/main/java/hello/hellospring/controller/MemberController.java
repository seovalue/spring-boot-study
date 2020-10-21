package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //멤버 서비스를 스프링이 가져다 연결시켜준다.
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
        System.out.println("memberService: "+memberService.getClass());
    }

    //get은 조회할 때 주로 사용
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //post로 전달할 때
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        /*
        * name이 널인 경우에는 입력받지 않도록 추가해보기.
        * */
        System.out.println(form.getName()); //form.html에서 name이 일치해야함.
        member.setName(form.getName());

        memberService.join(member); //회원가입
        return "redirect:/"; //회원가입이 끝나면 홈 화면으로 보냄.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
