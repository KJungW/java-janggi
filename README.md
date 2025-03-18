# :sparkling_heart: java-janggi 프로젝트 소개

웹 백엔드 7기 레벨1 장기 미션을 구현한 프로젝트입니다.

# :dart: 구현 기능 목록

## :rocket: 게임 시작

- [ ] 게임시작 문구 출력

```
장기 게임을 시작하겠습니다!
```

## :rocket: 기물 배치

- 초와 한의 초기 배치를 입력받을 수 있다.
    ```
    초의 초기 배치를 선택해주세요.
    1. 왼상(상마상마)
    2. 오른상(마상마상)
    3. 안상(마상상마)
    4. 바깥상(상마마상)
    2
    
    한의 초기 배치를 선택해주세요.
    1. 왼상(상마상마)
    2. 오른상(마상마상)
    3. 안상(마상상마)
    4. 바깥상(상마마상)
    1
    ```
- 초의 마와 상의 초기배치를 할 수 있다.
    - 왼상 : 상마상마
    - 오른상 : 마상마상
    - 안상 : 마상상마
    - 바깥상 : 상마마상
- 한의 마와 상의 초기배치를 할 수 있다.
    - 왼상 : 상마상마
    - 오른상 : 마상마상
    - 안상 : 마상상마
    - 바깥상 : 상마마상
- 초와 한의 나머지 말을 초기배치를 할 수 있다.

  ![janggi_batch.png](/image/janggi_batch.png)

  - 초기 장기판을 출력할 수 있다.

   ```
      ０ １ ２ ３ ４ ５ ６ ７ ８
    ０차 마 상 사 口 사 상 마 차
    １口 口 口 口 궁 口 口 口 口
    ２口 포 口 口 口 口 口 포 口
    ３졸 口 졸 口 졸 口 졸 口 졸
    ４口 口 口 口 口 口 口 口 口
    ５口 口 口 口 口 口 口 口 口
    ６졸 口 졸 口 졸 口 졸 口 졸
    ７口 포 口 口 口 口 口 포 口
    ８口 口 口 口 궁 口 口 口 口
    ９차 마 상 사 口 사 상 마 차
    ```


## :rocket: 장기말 이동

- 플레이 시작 문구 출력

    ```
    초나라 먼저 시작
    ```

- 초을 선수로 한과 번갈아가며 턴을 반복할 수 있다.

    ```
    이동할 장기말의 좌표 입력해주세요.
    0,1
    장기말의 좌표를 입력해주세요
    0,2
    ```

    - 예외처리 - 유효한 좌표가 아닌 경우

    ```
    [ERROR] x좌표는 0~8, y좌표는 0~9 사이로 입력해주세요.
    ```

    - 예외처리 - 유효한 좌표이지만 말이 없는 경우

    ```
    [ERROR] 해당 위치에 말이 존재하지 않습니다.
    ```

    - 예외처리 - 이동이 불가능한 위치인 경우

    ```
    [ERROR] 해당 위치로 이동할 수 없습니다.
    ```

- 각 장기말 별로 이동을 구현할 수 있다.
    - 궁
        - 8방향으로 1칸씩 이동
        - 궁안에서만 움직일 수 있음
    - 사
        - 8방향으로 1칸씩 이동
        - 궁안에서만 움직일 수 있음
    - 차
        - 동서남북 방향으로 끝까지 이동 가능
        - 장애물을 넘지 못함
        - 궁안에서 대각선을 타고 제한없이 이동 가능
    - 포
        - 혼자서는 움직일 수 없음
        - 장애물이 있어야지 넘어서 이동 가능
        - 포는 포를 잡을 수 없음
        - 포는 서로의 장애물이 될 수 없음
        - 궁안에서 이동 가능
    - 마
        - 동사남북 방향으로 1칸이동 후 대각선을 1칸이동
        - 장애물은 넘지 못한다.
        - 궁안에서는 첫번째 움짐임에서는 대각선 이동 불가능
    - 상
        - 동사남북 방향으로 1칸 이동 후 같은 방향의 대각선으로 2칸 이동
        - 궁안에서는 첫번째 움짐임에서는 대각선 이동 불가능
    - 졸
        - 동서북으로만 이동가능
        - 궁안에서 대각선 이동 가능