# 세로, 가로, 이동시간 입력
R, C, T = map(int, input().split())
# 주어진 맵 입력
board = list(list(input()) for _ in range(R))
# 4방 탐색 변수
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
# 최대값
max_ate = 0


# 시작점 찾기
def find_start():
    for i in range(R):
        for j in range(C):
            if board[i][j] == 'G':
                return i, j


# dfs
def dfs(r, c, cnt, t):
    # 시간 만료
    if t <= 0:
        global max_ate
        max_ate = max(max_ate, cnt)
        return

    # 4방 탐색
    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]

        # 범위 체크
        if nr < 0 or nr >= R or nc < 0 or nc >= C:
            continue
        if board[nr][nc] == '#':
            continue
        is_S = board[nr][nc] == 'S'

        if is_S:
            board[nr][nc] = '.'
        dfs(nr, nc, cnt + 1 if is_S else cnt, t - 1)
        if is_S:
            board[nr][nc] = 'S'


r, c = find_start()
dfs(r, c, 0, T)
print(max_ate)
