package com.backend.services.servicesImpl;

import java.util.List;
import java.util.Random;

import com.backend.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Account;
import com.backend.repository.AccountInforRepository;
import com.backend.repository.LoginAuthenticationRepository;
import com.backend.services.LoginAthenticationService;
import org.springframework.transaction.annotation.Transactional;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginAuthenticationImpl implements LoginAthenticationService {

	private final LoginAuthenticationRepository loginRepository;
	private final JavaMailSender mailSender;

	@Override
	public List<Account> getAllAccount() {
		return loginRepository.findAll();

	}

	@Override
	public boolean authenticateAcc(String username, String password) {
		Account acc = loginRepository.findByUsername(username);
		return acc != null && acc.getPassword().equals(password);
	}

	@Override
	public boolean isExistId(String id) {
		return loginRepository.findById(id).isPresent();
	}

	@Override
	public boolean isExistUsername(String username) {
		return loginRepository.findByUsername(username) != null;
	}

	@Override
	@Transactional
	public boolean registerAccount(Account acc) {
		var lastAcc = loginRepository.findLastAccount();
		if (lastAcc.isPresent()) {
			acc.setId(RandomUtil.getNextId(lastAcc.get().getId(), "AC"));
		} else {
			acc.setId(RandomUtil.getNextId(null, "AC"));
		}
		loginRepository.save(acc);
		return true;
	}

	@Override
	public String resetPassword(String email) {
		// TODO Auto-generated method stub

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		try {
			final String newPassword[] = new String[1];
			newPassword[0] = RandomUtil.generateRandomString(6);

			var acc = loginRepository.findByEmail(email);
			acc.ifPresentOrElse(account -> {
				account.setPassword(newPassword[0]);
				loginRepository.save(account);
			}, () -> {
				newPassword[0] = "NOT_FOUND_EMAIL";
			});
			if("NOT_FOUND_EMAIL".equals(newPassword[0])) {
				return "NOT_FOUND_EMAIL";
			}

			helper.setTo(email);
			helper.setFrom("TEDDY-STORE");
			helper.setSubject("RESET PASSWORD TEDDY-STORE");
			helper.setText("Mật khẩu mới của bạn là: " + newPassword[0], true);
			mailSender.send(mimeMessage);

			return newPassword[0];
		} catch (MessagingException e) {
			throw new RuntimeException("Failed to send email");
		}
	}

}
