# 백그라운드 실행, 강제 재생성, # 컨테이너 생성과 기동 수행 : d는 데몬으로 실행 옵션
db-up:
    docker-compose up -d --force-recreate

# volume 삭제, # 도커 삭제하는데 volume까지 삭제
db-down:
    docker-compose down -v