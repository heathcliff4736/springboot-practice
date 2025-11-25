package com.ssg.gallery.account.helper;

import com.ssg.gallery.account.dto.AccountJoinRequests;
import com.ssg.gallery.account.dto.AccountLoginRequests;
import com.ssg.gallery.account.etc.AccountConstants;
import com.ssg.gallery.common.util.HttpUtils;
import com.ssg.gallery.member.entity.Member;
import com.ssg.gallery.member.service.MemberSerivce;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAccountHelper implements AccountHelper {

    private final MemberSerivce memberService;

    @Override
    public void join(AccountJoinRequests joinReq) {
        memberService.save(joinReq.getName(), joinReq.getLoginId(), joinReq.getLoginPw());
    }

    @Override
    public String login(AccountLoginRequests loginReq, HttpServletRequest request, HttpServletResponse response) {
        Member member = memberService.find(loginReq.getLoginId(), loginReq.getLoginPw());

        // 회원 데이터가 없으면
        if (member == null) {
            return null;
        }
        HttpUtils.setSession(request, AccountConstants.Member_ID_NAME, member.getId());
//        return member.getLogin_id().toString();
        return member.getLoginId().toString();
    }

    // 회원 아이디 조회
    @Override
    public Integer getMemberId(HttpServletRequest request) {
        Object memberId = HttpUtils.getSession(request, AccountConstants.Member_ID_NAME);
        if(memberId != null) { return (int) memberId; }
        return null;
    }

    // 로그인 여부 확인
    @Override
    public boolean isLoggedIn(HttpServletRequest request) {
        return getMemberId(request) != null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpUtils.removeSession(request, AccountConstants.Member_ID_NAME);
    }
}
