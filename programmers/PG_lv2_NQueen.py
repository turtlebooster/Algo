def solution(n):
    answer = 0

    global N, cnt
    N = n
    cnt = 0
    put_queen(0, 0, 0, 0, 0)

    answer = cnt
    return answer


def put_queen(idx, row, col, dia1, dia2):
    # 마지막 줄 까지 모두 놓았을 경우
    if idx >= N:
        global cnt
        cnt += 1
        return

    # 이번 행에서 놓을 열 선정
    for c in range(0, N):
        r_bit = 1 << idx
        c_bit = 1 << c
        d1_bit = 1 << (idx + c)
        d2_bit = 1 << (idx - c + N)

        # 세로, 대각선 공격 가능한 자리일 경우 패스
        if col & c_bit > 0 or dia1 & d1_bit > 0 or dia2 & d2_bit > 0:
            continue

        # 해당 자리에 놓고 다음 줄로 넘어가기
        put_queen(idx + 1, row | r_bit, col | c_bit, dia1 | d1_bit, dia2 | d2_bit)

    return
