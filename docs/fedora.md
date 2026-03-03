# Fedora-related issues

* Docker 설정하다가 노트북 날려먹을뻔한 이야기

Fedora Linux에서 Docker를 사용할 때에는 `sudo`를 사용해야 하고, 그러지 않으려면 사용자를 docker 그룹에 포함시키거나 (보안상 권장되지 않음) "rootless Docker"를 사용해야 한다.

첫번째 방법을 테스트해보기 위해 사용자 권한을 사용하다가 `usermod -G docker user`를 해버렸다. `usermod -aG`는 사용자를 특정 사용자그룹에 포함시키는 명령어지만, `-aG` 대신 `-G` 옵션을 주면 사용자의 사용자그룹을 그 설정으로 바꾸기 때문에, `usermod -G docker user`를 하면 사용자를 `sudoer` 그룹(Fedora의 경우에는 `wheel`)에서 제외시켜버린다.

기본적으로 root 계정을 잠그고, 다른 계정이 `sudo`를 통해서만 root를 사용할 수 있는 경우에 이는 사실상 "키를 안에 두고 집 문 잠그기"를 하는 셈이다.

그래도 해결방법이 없지는 않다. Linux 부팅 시에 `Esc` 키를 눌러 GRUB bootloader 화면에 접근할 수 있는데, 여기서 부트 시의 옵션을 임의로 추가할 수 있다. 여기서 root의 /bin/bash 로 강제로 부팅하고, user의 sudoer 권한을 복구하고 SELinux가 labeling을 다시 할 수 있게 지정해주면 된다.

부트 시에 다음 옵션을 `linux {...}` 행에 추가한다.

`rw init=/bin/bash`

이 명령어로 `rw`: 읽고 쓰는 권한을 받아 `/bin/bash`로 부트한다.


